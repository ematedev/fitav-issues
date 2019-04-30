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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFAddressModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFAddress service. Represents a row in the &quot;ESFAddress&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFAddressModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFAddressImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFAddressImpl
 * @see it.ethica.esf.model.ESFAddress
 * @see it.ethica.esf.model.ESFAddressModel
 * @generated
 */
@JSON(strict = true)
public class ESFAddressModelImpl extends BaseModelImpl<ESFAddress>
	implements ESFAddressModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f address model instance should use the {@link it.ethica.esf.model.ESFAddress} interface instead.
	 */
	public static final String TABLE_NAME = "ESFAddress";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "esfAddressId", Types.BIGINT },
			{ "longitude", Types.DOUBLE },
			{ "latitude", Types.DOUBLE },
			{ "esfCountryId", Types.VARCHAR },
			{ "esfRegionId", Types.VARCHAR },
			{ "esfProvinceId", Types.VARCHAR },
			{ "esfCityId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "type_", Types.VARCHAR },
			{ "isNotNational", Types.BOOLEAN },
			{ "listTypeId", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFAddress (uuid_ VARCHAR(75) null,esfAddressId LONG not null primary key,longitude DOUBLE,latitude DOUBLE,esfCountryId VARCHAR(75) null,esfRegionId VARCHAR(75) null,esfProvinceId VARCHAR(75) null,esfCityId LONG,groupId LONG,type_ VARCHAR(75) null,isNotNational BOOLEAN,listTypeId INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ESFAddress";
	public static final String ORDER_BY_JPQL = " ORDER BY esfAddress.esfAddressId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFAddress.esfAddressId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFAddress"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFAddress"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFAddress"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long LATITUDE_COLUMN_BITMASK = 2L;
	public static long LONGITUDE_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;
	public static long ESFADDRESSID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFAddress"));

	public ESFAddressModelImpl() {
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
	public Class<?> getModelClass() {
		return ESFAddress.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAddress.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfAddressId", getEsfAddressId());
		attributes.put("longitude", getLongitude());
		attributes.put("latitude", getLatitude());
		attributes.put("esfCountryId", getEsfCountryId());
		attributes.put("esfRegionId", getEsfRegionId());
		attributes.put("esfProvinceId", getEsfProvinceId());
		attributes.put("esfCityId", getEsfCityId());
		attributes.put("groupId", getGroupId());
		attributes.put("type", getType());
		attributes.put("isNotNational", getIsNotNational());
		attributes.put("listTypeId", getListTypeId());

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

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
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

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Boolean isNotNational = (Boolean)attributes.get("isNotNational");

		if (isNotNational != null) {
			setIsNotNational(isNotNational);
		}

		Integer listTypeId = (Integer)attributes.get("listTypeId");

		if (listTypeId != null) {
			setListTypeId(listTypeId);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getEsfAddressId() {
		return _esfAddressId;
	}

	@Override
	public void setEsfAddressId(long esfAddressId) {
		_esfAddressId = esfAddressId;
	}

	@JSON
	@Override
	public double getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(double longitude) {
		_columnBitmask |= LONGITUDE_COLUMN_BITMASK;

		if (!_setOriginalLongitude) {
			_setOriginalLongitude = true;

			_originalLongitude = _longitude;
		}

		_longitude = longitude;
	}

	public double getOriginalLongitude() {
		return _originalLongitude;
	}

	@JSON
	@Override
	public double getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(double latitude) {
		_columnBitmask |= LATITUDE_COLUMN_BITMASK;

		if (!_setOriginalLatitude) {
			_setOriginalLatitude = true;

			_originalLatitude = _latitude;
		}

		_latitude = latitude;
	}

	public double getOriginalLatitude() {
		return _originalLatitude;
	}

	@JSON
	@Override
	public String getEsfCountryId() {
		if (_esfCountryId == null) {
			return StringPool.BLANK;
		}
		else {
			return _esfCountryId;
		}
	}

	@Override
	public void setEsfCountryId(String esfCountryId) {
		_esfCountryId = esfCountryId;
	}

	@JSON
	@Override
	public String getEsfRegionId() {
		if (_esfRegionId == null) {
			return StringPool.BLANK;
		}
		else {
			return _esfRegionId;
		}
	}

	@Override
	public void setEsfRegionId(String esfRegionId) {
		_esfRegionId = esfRegionId;
	}

	@JSON
	@Override
	public String getEsfProvinceId() {
		if (_esfProvinceId == null) {
			return StringPool.BLANK;
		}
		else {
			return _esfProvinceId;
		}
	}

	@Override
	public void setEsfProvinceId(String esfProvinceId) {
		_esfProvinceId = esfProvinceId;
	}

	@JSON
	@Override
	public long getEsfCityId() {
		return _esfCityId;
	}

	@Override
	public void setEsfCityId(long esfCityId) {
		_esfCityId = esfCityId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@JSON
	@Override
	public boolean getIsNotNational() {
		return _isNotNational;
	}

	@Override
	public boolean isIsNotNational() {
		return _isNotNational;
	}

	@Override
	public void setIsNotNational(boolean isNotNational) {
		_isNotNational = isNotNational;
	}

	@JSON
	@Override
	public int getListTypeId() {
		return _listTypeId;
	}

	@Override
	public void setListTypeId(int listTypeId) {
		_listTypeId = listTypeId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFAddress.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFAddress toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFAddress)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFAddressImpl esfAddressImpl = new ESFAddressImpl();

		esfAddressImpl.setUuid(getUuid());
		esfAddressImpl.setEsfAddressId(getEsfAddressId());
		esfAddressImpl.setLongitude(getLongitude());
		esfAddressImpl.setLatitude(getLatitude());
		esfAddressImpl.setEsfCountryId(getEsfCountryId());
		esfAddressImpl.setEsfRegionId(getEsfRegionId());
		esfAddressImpl.setEsfProvinceId(getEsfProvinceId());
		esfAddressImpl.setEsfCityId(getEsfCityId());
		esfAddressImpl.setGroupId(getGroupId());
		esfAddressImpl.setType(getType());
		esfAddressImpl.setIsNotNational(getIsNotNational());
		esfAddressImpl.setListTypeId(getListTypeId());

		esfAddressImpl.resetOriginalValues();

		return esfAddressImpl;
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

		if (!(obj instanceof ESFAddress)) {
			return false;
		}

		ESFAddress esfAddress = (ESFAddress)obj;

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
	public void resetOriginalValues() {
		ESFAddressModelImpl esfAddressModelImpl = this;

		esfAddressModelImpl._originalUuid = esfAddressModelImpl._uuid;

		esfAddressModelImpl._originalLongitude = esfAddressModelImpl._longitude;

		esfAddressModelImpl._setOriginalLongitude = false;

		esfAddressModelImpl._originalLatitude = esfAddressModelImpl._latitude;

		esfAddressModelImpl._setOriginalLatitude = false;

		esfAddressModelImpl._originalGroupId = esfAddressModelImpl._groupId;

		esfAddressModelImpl._setOriginalGroupId = false;

		esfAddressModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFAddress> toCacheModel() {
		ESFAddressCacheModel esfAddressCacheModel = new ESFAddressCacheModel();

		esfAddressCacheModel.uuid = getUuid();

		String uuid = esfAddressCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			esfAddressCacheModel.uuid = null;
		}

		esfAddressCacheModel.esfAddressId = getEsfAddressId();

		esfAddressCacheModel.longitude = getLongitude();

		esfAddressCacheModel.latitude = getLatitude();

		esfAddressCacheModel.esfCountryId = getEsfCountryId();

		String esfCountryId = esfAddressCacheModel.esfCountryId;

		if ((esfCountryId != null) && (esfCountryId.length() == 0)) {
			esfAddressCacheModel.esfCountryId = null;
		}

		esfAddressCacheModel.esfRegionId = getEsfRegionId();

		String esfRegionId = esfAddressCacheModel.esfRegionId;

		if ((esfRegionId != null) && (esfRegionId.length() == 0)) {
			esfAddressCacheModel.esfRegionId = null;
		}

		esfAddressCacheModel.esfProvinceId = getEsfProvinceId();

		String esfProvinceId = esfAddressCacheModel.esfProvinceId;

		if ((esfProvinceId != null) && (esfProvinceId.length() == 0)) {
			esfAddressCacheModel.esfProvinceId = null;
		}

		esfAddressCacheModel.esfCityId = getEsfCityId();

		esfAddressCacheModel.groupId = getGroupId();

		esfAddressCacheModel.type = getType();

		String type = esfAddressCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			esfAddressCacheModel.type = null;
		}

		esfAddressCacheModel.isNotNational = getIsNotNational();

		esfAddressCacheModel.listTypeId = getListTypeId();

		return esfAddressCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfAddressId=");
		sb.append(getEsfAddressId());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", latitude=");
		sb.append(getLatitude());
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
		sb.append(", type=");
		sb.append(getType());
		sb.append(", isNotNational=");
		sb.append(getIsNotNational());
		sb.append(", listTypeId=");
		sb.append(getListTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

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
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
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
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNotNational</column-name><column-value><![CDATA[");
		sb.append(getIsNotNational());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>listTypeId</column-name><column-value><![CDATA[");
		sb.append(getListTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFAddress.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFAddress.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _esfAddressId;
	private double _longitude;
	private double _originalLongitude;
	private boolean _setOriginalLongitude;
	private double _latitude;
	private double _originalLatitude;
	private boolean _setOriginalLatitude;
	private String _esfCountryId;
	private String _esfRegionId;
	private String _esfProvinceId;
	private long _esfCityId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _type;
	private boolean _isNotNational;
	private int _listTypeId;
	private long _columnBitmask;
	private ESFAddress _escapedModel;
}