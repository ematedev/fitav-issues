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
import it.ethica.esf.service.ESFCityLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFCityPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFCityClp extends BaseModelImpl<ESFCity> implements ESFCity {
	public ESFCityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCity.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCity.class.getName();
	}

	@Override
	public ESFCityPK getPrimaryKey() {
		return new ESFCityPK(_idCity, _idProvince, _idRegion, _idCountry);
	}

	@Override
	public void setPrimaryKey(ESFCityPK primaryKey) {
		setIdCity(primaryKey.idCity);
		setIdProvince(primaryKey.idProvince);
		setIdRegion(primaryKey.idRegion);
		setIdCountry(primaryKey.idCountry);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFCityPK(_idCity, _idProvince, _idRegion, _idCountry);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFCityPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idCity", getIdCity());
		attributes.put("idProvince", getIdProvince());
		attributes.put("idRegion", getIdRegion());
		attributes.put("idCountry", getIdCountry());
		attributes.put("zip", getZip());
		attributes.put("name", getName());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("altitude", getAltitude());
		attributes.put("website", getWebsite());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idCity = (Long)attributes.get("idCity");

		if (idCity != null) {
			setIdCity(idCity);
		}

		String idProvince = (String)attributes.get("idProvince");

		if (idProvince != null) {
			setIdProvince(idProvince);
		}

		String idRegion = (String)attributes.get("idRegion");

		if (idRegion != null) {
			setIdRegion(idRegion);
		}

		String idCountry = (String)attributes.get("idCountry");

		if (idCountry != null) {
			setIdCountry(idCountry);
		}

		Long zip = (Long)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Double altitude = (Double)attributes.get("altitude");

		if (altitude != null) {
			setAltitude(altitude);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}
	}

	@Override
	public long getIdCity() {
		return _idCity;
	}

	@Override
	public void setIdCity(long idCity) {
		_idCity = idCity;

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setIdCity", long.class);

				method.invoke(_esfCityRemoteModel, idCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdProvince() {
		return _idProvince;
	}

	@Override
	public void setIdProvince(String idProvince) {
		_idProvince = idProvince;

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setIdProvince", String.class);

				method.invoke(_esfCityRemoteModel, idProvince);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdRegion() {
		return _idRegion;
	}

	@Override
	public void setIdRegion(String idRegion) {
		_idRegion = idRegion;

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setIdRegion", String.class);

				method.invoke(_esfCityRemoteModel, idRegion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdCountry() {
		return _idCountry;
	}

	@Override
	public void setIdCountry(String idCountry) {
		_idCountry = idCountry;

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setIdCountry", String.class);

				method.invoke(_esfCityRemoteModel, idCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getZip() {
		return _zip;
	}

	@Override
	public void setZip(long zip) {
		_zip = zip;

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setZip", long.class);

				method.invoke(_esfCityRemoteModel, zip);
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

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfCityRemoteModel, name);
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

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", double.class);

				method.invoke(_esfCityRemoteModel, latitude);
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

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", double.class);

				method.invoke(_esfCityRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAltitude() {
		return _altitude;
	}

	@Override
	public void setAltitude(double altitude) {
		_altitude = altitude;

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setAltitude", double.class);

				method.invoke(_esfCityRemoteModel, altitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebsite() {
		return _website;
	}

	@Override
	public void setWebsite(String website) {
		_website = website;

		if (_esfCityRemoteModel != null) {
			try {
				Class<?> clazz = _esfCityRemoteModel.getClass();

				Method method = clazz.getMethod("setWebsite", String.class);

				method.invoke(_esfCityRemoteModel, website);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFCityRemoteModel() {
		return _esfCityRemoteModel;
	}

	public void setESFCityRemoteModel(BaseModel<?> esfCityRemoteModel) {
		_esfCityRemoteModel = esfCityRemoteModel;
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

		Class<?> remoteModelClass = _esfCityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfCityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFCityLocalServiceUtil.addESFCity(this);
		}
		else {
			ESFCityLocalServiceUtil.updateESFCity(this);
		}
	}

	@Override
	public ESFCity toEscapedModel() {
		return (ESFCity)ProxyUtil.newProxyInstance(ESFCity.class.getClassLoader(),
			new Class[] { ESFCity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFCityClp clone = new ESFCityClp();

		clone.setIdCity(getIdCity());
		clone.setIdProvince(getIdProvince());
		clone.setIdRegion(getIdRegion());
		clone.setIdCountry(getIdCountry());
		clone.setZip(getZip());
		clone.setName(getName());
		clone.setLatitude(getLatitude());
		clone.setLongitude(getLongitude());
		clone.setAltitude(getAltitude());
		clone.setWebsite(getWebsite());

		return clone;
	}

	@Override
	public int compareTo(ESFCity esfCity) {
		int value = 0;

		value = getName().compareTo(esfCity.getName());

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

		if (!(obj instanceof ESFCityClp)) {
			return false;
		}

		ESFCityClp esfCity = (ESFCityClp)obj;

		ESFCityPK primaryKey = esfCity.getPrimaryKey();

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

		sb.append("{idCity=");
		sb.append(getIdCity());
		sb.append(", idProvince=");
		sb.append(getIdProvince());
		sb.append(", idRegion=");
		sb.append(getIdRegion());
		sb.append(", idCountry=");
		sb.append(getIdCountry());
		sb.append(", zip=");
		sb.append(getZip());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", altitude=");
		sb.append(getAltitude());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFCity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idCity</column-name><column-value><![CDATA[");
		sb.append(getIdCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idProvince</column-name><column-value><![CDATA[");
		sb.append(getIdProvince());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idRegion</column-name><column-value><![CDATA[");
		sb.append(getIdRegion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCountry</column-name><column-value><![CDATA[");
		sb.append(getIdCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zip</column-name><column-value><![CDATA[");
		sb.append(getZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
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
			"<column><column-name>altitude</column-name><column-value><![CDATA[");
		sb.append(getAltitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idCity;
	private String _idProvince;
	private String _idRegion;
	private String _idCountry;
	private long _zip;
	private String _name;
	private double _latitude;
	private double _longitude;
	private double _altitude;
	private String _website;
	private BaseModel<?> _esfCityRemoteModel;
}