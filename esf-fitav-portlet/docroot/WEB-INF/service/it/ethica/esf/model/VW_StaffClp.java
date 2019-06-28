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
import it.ethica.esf.service.VW_StaffLocalServiceUtil;
import it.ethica.esf.service.persistence.VW_StaffPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class VW_StaffClp extends BaseModelImpl<VW_Staff> implements VW_Staff {
	public VW_StaffClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VW_Staff.class;
	}

	@Override
	public String getModelClassName() {
		return VW_Staff.class.getName();
	}

	@Override
	public VW_StaffPK getPrimaryKey() {
		return new VW_StaffPK(_userId, _regionId, _provinceId, _esfSportTypeId);
	}

	@Override
	public void setPrimaryKey(VW_StaffPK primaryKey) {
		setUserId(primaryKey.userId);
		setRegionId(primaryKey.regionId);
		setProvinceId(primaryKey.provinceId);
		setEsfSportTypeId(primaryKey.esfSportTypeId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VW_StaffPK(_userId, _regionId, _provinceId, _esfSportTypeId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VW_StaffPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("createDate", getCreateDate());
		attributes.put("esfStartData", getEsfStartData());
		attributes.put("esfEndData", getEsfEndData());
		attributes.put("regionId", getRegionId());
		attributes.put("provinceId", getProvinceId());
		attributes.put("esfShootingDirectorQualificationDesc",
			getEsfShootingDirectorQualificationDesc());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("name", getName());
		attributes.put("invitato", getInvitato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date esfStartData = (Date)attributes.get("esfStartData");

		if (esfStartData != null) {
			setEsfStartData(esfStartData);
		}

		Date esfEndData = (Date)attributes.get("esfEndData");

		if (esfEndData != null) {
			setEsfEndData(esfEndData);
		}

		String regionId = (String)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String provinceId = (String)attributes.get("provinceId");

		if (provinceId != null) {
			setProvinceId(provinceId);
		}

		String esfShootingDirectorQualificationDesc = (String)attributes.get(
				"esfShootingDirectorQualificationDesc");

		if (esfShootingDirectorQualificationDesc != null) {
			setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualificationDesc);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long invitato = (Long)attributes.get("invitato");

		if (invitato != null) {
			setInvitato(invitato);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vw_StaffRemoteModel, userId);
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
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_vw_StaffRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_vw_StaffRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_vw_StaffRemoteModel, lastName);
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

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_vw_StaffRemoteModel, createDate);
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

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfStartData", Date.class);

				method.invoke(_vw_StaffRemoteModel, esfStartData);
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

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfEndData", Date.class);

				method.invoke(_vw_StaffRemoteModel, esfEndData);
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

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", String.class);

				method.invoke(_vw_StaffRemoteModel, regionId);
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

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setProvinceId", String.class);

				method.invoke(_vw_StaffRemoteModel, provinceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfShootingDirectorQualificationDesc() {
		return _esfShootingDirectorQualificationDesc;
	}

	@Override
	public void setEsfShootingDirectorQualificationDesc(
		String esfShootingDirectorQualificationDesc) {
		_esfShootingDirectorQualificationDesc = esfShootingDirectorQualificationDesc;

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShootingDirectorQualificationDesc",
						String.class);

				method.invoke(_vw_StaffRemoteModel,
					esfShootingDirectorQualificationDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSportTypeId", long.class);

				method.invoke(_vw_StaffRemoteModel, esfSportTypeId);
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

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_vw_StaffRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInvitato() {
		return _invitato;
	}

	@Override
	public void setInvitato(long invitato) {
		_invitato = invitato;

		if (_vw_StaffRemoteModel != null) {
			try {
				Class<?> clazz = _vw_StaffRemoteModel.getClass();

				Method method = clazz.getMethod("setInvitato", long.class);

				method.invoke(_vw_StaffRemoteModel, invitato);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVW_StaffRemoteModel() {
		return _vw_StaffRemoteModel;
	}

	public void setVW_StaffRemoteModel(BaseModel<?> vw_StaffRemoteModel) {
		_vw_StaffRemoteModel = vw_StaffRemoteModel;
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

		Class<?> remoteModelClass = _vw_StaffRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vw_StaffRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VW_StaffLocalServiceUtil.addVW_Staff(this);
		}
		else {
			VW_StaffLocalServiceUtil.updateVW_Staff(this);
		}
	}

	@Override
	public VW_Staff toEscapedModel() {
		return (VW_Staff)ProxyUtil.newProxyInstance(VW_Staff.class.getClassLoader(),
			new Class[] { VW_Staff.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VW_StaffClp clone = new VW_StaffClp();

		clone.setUserId(getUserId());
		clone.setEmailAddress(getEmailAddress());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setCreateDate(getCreateDate());
		clone.setEsfStartData(getEsfStartData());
		clone.setEsfEndData(getEsfEndData());
		clone.setRegionId(getRegionId());
		clone.setProvinceId(getProvinceId());
		clone.setEsfShootingDirectorQualificationDesc(getEsfShootingDirectorQualificationDesc());
		clone.setEsfSportTypeId(getEsfSportTypeId());
		clone.setName(getName());
		clone.setInvitato(getInvitato());

		return clone;
	}

	@Override
	public int compareTo(VW_Staff vw_Staff) {
		VW_StaffPK primaryKey = vw_Staff.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_StaffClp)) {
			return false;
		}

		VW_StaffClp vw_Staff = (VW_StaffClp)obj;

		VW_StaffPK primaryKey = vw_Staff.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", esfStartData=");
		sb.append(getEsfStartData());
		sb.append(", esfEndData=");
		sb.append(getEsfEndData());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", provinceId=");
		sb.append(getProvinceId());
		sb.append(", esfShootingDirectorQualificationDesc=");
		sb.append(getEsfShootingDirectorQualificationDesc());
		sb.append(", esfSportTypeId=");
		sb.append(getEsfSportTypeId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", invitato=");
		sb.append(getInvitato());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.VW_Staff");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
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
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>provinceId</column-name><column-value><![CDATA[");
		sb.append(getProvinceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShootingDirectorQualificationDesc</column-name><column-value><![CDATA[");
		sb.append(getEsfShootingDirectorQualificationDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSportTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invitato</column-name><column-value><![CDATA[");
		sb.append(getInvitato());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private String _emailAddress;
	private String _firstName;
	private String _lastName;
	private Date _createDate;
	private Date _esfStartData;
	private Date _esfEndData;
	private String _regionId;
	private String _provinceId;
	private String _esfShootingDirectorQualificationDesc;
	private long _esfSportTypeId;
	private String _name;
	private long _invitato;
	private BaseModel<?> _vw_StaffRemoteModel;
}