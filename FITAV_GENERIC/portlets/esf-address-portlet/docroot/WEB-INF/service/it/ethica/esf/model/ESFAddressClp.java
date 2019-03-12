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

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFAddressClp extends BaseModelImpl<ESFAddress>
	implements ESFAddress {
	public ESFAddressClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFAddress.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAddress.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfAddressId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfAddressId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfAddressId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfAddressId", getEsfAddressId());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("esfCountryId", getEsfCountryId());
		attributes.put("esfRegionId", getEsfRegionId());
		attributes.put("esfProvinceId", getEsfProvinceId());
		attributes.put("esfCityId", getEsfCityId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfAddressId = (Long)attributes.get("esfAddressId");

		if (esfAddressId != null) {
			setEsfAddressId(esfAddressId);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String esfCountryId = (String)attributes.get("esfCountryId");

		if (esfCountryId != null) {
			setEsfCountryId(esfCountryId);
		}

		String esfRegionId = (String)attributes.get("esfRegionId");

		if (esfRegionId != null) {
			setEsfRegionId(esfRegionId);
		}

		String esfProvinceId = (String)attributes.get("esfProvinceId");

		if (esfProvinceId != null) {
			setEsfProvinceId(esfProvinceId);
		}

		Long esfCityId = (Long)attributes.get("esfCityId");

		if (esfCityId != null) {
			setEsfCityId(esfCityId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfAddressRemoteModel != null) {
			try {
				Class<?> clazz = _esfAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfAddressRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfAddressId() {
		return _esfAddressId;
	}

	@Override
	public void setEsfAddressId(long esfAddressId) {
		_esfAddressId = esfAddressId;

		if (_esfAddressRemoteModel != null) {
			try {
				Class<?> clazz = _esfAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfAddressId", long.class);

				method.invoke(_esfAddressRemoteModel, esfAddressId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(double latitude) {
		_latitude = latitude;

		if (_esfAddressRemoteModel != null) {
			try {
				Class<?> clazz = _esfAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", double.class);

				method.invoke(_esfAddressRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(double longitude) {
		_longitude = longitude;

		if (_esfAddressRemoteModel != null) {
			try {
				Class<?> clazz = _esfAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", double.class);

				method.invoke(_esfAddressRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfCountryId() {
		return _esfCountryId;
	}

	@Override
	public void setEsfCountryId(String esfCountryId) {
		_esfCountryId = esfCountryId;

		if (_esfAddressRemoteModel != null) {
			try {
				Class<?> clazz = _esfAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCountryId", String.class);

				method.invoke(_esfAddressRemoteModel, esfCountryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfRegionId() {
		return _esfRegionId;
	}

	@Override
	public void setEsfRegionId(String esfRegionId) {
		_esfRegionId = esfRegionId;

		if (_esfAddressRemoteModel != null) {
			try {
				Class<?> clazz = _esfAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfRegionId", String.class);

				method.invoke(_esfAddressRemoteModel, esfRegionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfProvinceId() {
		return _esfProvinceId;
	}

	@Override
	public void setEsfProvinceId(String esfProvinceId) {
		_esfProvinceId = esfProvinceId;

		if (_esfAddressRemoteModel != null) {
			try {
				Class<?> clazz = _esfAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfProvinceId", String.class);

				method.invoke(_esfAddressRemoteModel, esfProvinceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfCityId() {
		return _esfCityId;
	}

	@Override
	public void setEsfCityId(long esfCityId) {
		_esfCityId = esfCityId;

		if (_esfAddressRemoteModel != null) {
			try {
				Class<?> clazz = _esfAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCityId", long.class);

				method.invoke(_esfAddressRemoteModel, esfCityId);
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

		if (_esfAddressRemoteModel != null) {
			try {
				Class<?> clazz = _esfAddressRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfAddressRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setPrimary_(boolean primary_) {
		try {
			String methodName = "setPrimary_";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { primary_ };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getCompanyId() {
		try {
			String methodName = "getCompanyId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getTypeId() {
		try {
			String methodName = "getTypeId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setClassPk(long classPk) {
		try {
			String methodName = "setClassPk";

			Class<?>[] parameterTypes = new Class<?>[] { long.class };

			Object[] parameterValues = new Object[] { classPk };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStreet2(java.lang.String street2) {
		try {
			String methodName = "setStreet2";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { street2 };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		try {
			String methodName = "setModifiedDate";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Date.class };

			Object[] parameterValues = new Object[] { modifiedDate };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setMailing(boolean mailing) {
		try {
			String methodName = "setMailing";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { mailing };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStreet2() {
		try {
			String methodName = "getStreet2";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getZip() {
		try {
			String methodName = "getZip";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStreet3() {
		try {
			String methodName = "getStreet3";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setZip(java.lang.String zip) {
		try {
			String methodName = "setZip";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { zip };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setTypeId(int typeId) {
		try {
			String methodName = "setTypeId";

			Class<?>[] parameterTypes = new Class<?>[] { int.class };

			Object[] parameterValues = new Object[] { typeId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.Date getModifiedDate() {
		try {
			String methodName = "getModifiedDate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.Date returnObj = (java.util.Date)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getClassPk() {
		try {
			String methodName = "getClassPk";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setCreateDate(java.util.Date createDate) {
		try {
			String methodName = "setCreateDate";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Date.class };

			Object[] parameterValues = new Object[] { createDate };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStreet1() {
		try {
			String methodName = "getStreet1";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.Date getCreateDate() {
		try {
			String methodName = "getCreateDate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.Date returnObj = (java.util.Date)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getUserId() {
		try {
			String methodName = "getUserId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setUserId(long userId) {
		try {
			String methodName = "setUserId";

			Class<?>[] parameterTypes = new Class<?>[] { long.class };

			Object[] parameterValues = new Object[] { userId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getClassNameId() {
		try {
			String methodName = "getClassNameId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setUserName(java.lang.String userName) {
		try {
			String methodName = "setUserName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { userName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setClassNameId(long classNameId) {
		try {
			String methodName = "setClassNameId";

			Class<?>[] parameterTypes = new Class<?>[] { long.class };

			Object[] parameterValues = new Object[] { classNameId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean getMailing() {
		try {
			String methodName = "getMailing";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getUserName() {
		try {
			String methodName = "getUserName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setCompanyId(long companyId) {
		try {
			String methodName = "setCompanyId";

			Class<?>[] parameterTypes = new Class<?>[] { long.class };

			Object[] parameterValues = new Object[] { companyId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStreet1(java.lang.String street1) {
		try {
			String methodName = "setStreet1";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { street1 };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStreet3(java.lang.String street3) {
		try {
			String methodName = "setStreet3";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { street3 };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean getPrimary_() {
		try {
			String methodName = "getPrimary_";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getESFAddressRemoteModel() {
		return _esfAddressRemoteModel;
	}

	public void setESFAddressRemoteModel(BaseModel<?> esfAddressRemoteModel) {
		_esfAddressRemoteModel = esfAddressRemoteModel;
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

		Class<?> remoteModelClass = _esfAddressRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfAddressRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFAddressLocalServiceUtil.addESFAddress(this);
		}
		else {
			ESFAddressLocalServiceUtil.updateESFAddress(this);
		}
	}

	@Override
	public ESFAddress toEscapedModel() {
		return (ESFAddress)ProxyUtil.newProxyInstance(ESFAddress.class.getClassLoader(),
			new Class[] { ESFAddress.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFAddressClp clone = new ESFAddressClp();

		clone.setUuid(getUuid());
		clone.setEsfAddressId(getEsfAddressId());
		clone.setLatitude(getLatitude());
		clone.setLongitude(getLongitude());
		clone.setEsfCountryId(getEsfCountryId());
		clone.setEsfRegionId(getEsfRegionId());
		clone.setEsfProvinceId(getEsfProvinceId());
		clone.setEsfCityId(getEsfCityId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(ESFAddress esfAddress) {
		long primaryKey = esfAddress.getPrimaryKey();

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

		if (!(obj instanceof ESFAddressClp)) {
			return false;
		}

		ESFAddressClp esfAddress = (ESFAddressClp)obj;

		long primaryKey = esfAddress.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfAddressId=");
		sb.append(getEsfAddressId());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", esfCountryId=");
		sb.append(getEsfCountryId());
		sb.append(", esfRegionId=");
		sb.append(getEsfRegionId());
		sb.append(", esfProvinceId=");
		sb.append(getEsfProvinceId());
		sb.append(", esfCityId=");
		sb.append(getEsfCityId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFAddress");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfAddressId</column-name><column-value><![CDATA[");
		sb.append(getEsfAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCountryId</column-name><column-value><![CDATA[");
		sb.append(getEsfCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfRegionId</column-name><column-value><![CDATA[");
		sb.append(getEsfRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfProvinceId</column-name><column-value><![CDATA[");
		sb.append(getEsfProvinceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCityId</column-name><column-value><![CDATA[");
		sb.append(getEsfCityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfAddressId;
	private double _latitude;
	private double _longitude;
	private String _esfCountryId;
	private String _esfRegionId;
	private String _esfProvinceId;
	private long _esfCityId;
	private long _groupId;
	private BaseModel<?> _esfAddressRemoteModel;
}