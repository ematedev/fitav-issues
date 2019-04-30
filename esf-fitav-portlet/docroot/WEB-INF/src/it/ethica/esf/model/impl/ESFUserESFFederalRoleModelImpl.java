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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.model.ESFUserESFFederalRole;
import it.ethica.esf.model.ESFUserESFFederalRoleModel;
import it.ethica.esf.service.persistence.ESFUserESFFederalRolePK;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFUserESFFederalRole service. Represents a row in the &quot;ESFUserESFFederalRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFUserESFFederalRoleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFUserESFFederalRoleImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserESFFederalRoleImpl
 * @see it.ethica.esf.model.ESFUserESFFederalRole
 * @see it.ethica.esf.model.ESFUserESFFederalRoleModel
 * @generated
 */
@JSON(strict = true)
public class ESFUserESFFederalRoleModelImpl extends BaseModelImpl<ESFUserESFFederalRole>
	implements ESFUserESFFederalRoleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f user e s f federal role model instance should use the {@link it.ethica.esf.model.ESFUserESFFederalRole} interface instead.
	 */
	public static final String TABLE_NAME = "ESFUserESFFederalRole";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfUserId", Types.BIGINT },
			{ "esfFederalRoleId", Types.BIGINT },
			{ "startDate", Types.BIGINT },
			{ "endDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "active_", Types.BOOLEAN },
			{ "esfSpecificId", Types.BIGINT },
			{ "regionId", Types.VARCHAR },
			{ "provinceId", Types.VARCHAR },
			{ "notes", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFUserESFFederalRole (esfUserId LONG not null,esfFederalRoleId LONG not null,startDate LONG not null,endDate DATE null,modifiedDate DATE null,active_ BOOLEAN,esfSpecificId LONG,regionId VARCHAR(75) null,provinceId VARCHAR(75) null,notes VARCHAR(75) null,primary key (esfUserId, esfFederalRoleId, startDate))";
	public static final String TABLE_SQL_DROP = "drop table ESFUserESFFederalRole";
	public static final String ORDER_BY_JPQL = " ORDER BY esfUserESFFederalRole.id.esfUserId ASC, esfUserESFFederalRole.id.esfFederalRoleId ASC, esfUserESFFederalRole.id.startDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFUserESFFederalRole.esfUserId ASC, ESFUserESFFederalRole.esfFederalRoleId ASC, ESFUserESFFederalRole.startDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFUserESFFederalRole"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFUserESFFederalRole"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFUserESFFederalRole"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long ESFFEDERALROLEID_COLUMN_BITMASK = 2L;
	public static long ESFUSERID_COLUMN_BITMASK = 4L;
	public static long STARTDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFUserESFFederalRole"));

	public ESFUserESFFederalRoleModelImpl() {
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
	public Class<?> getModelClass() {
		return ESFUserESFFederalRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserESFFederalRole.class.getName();
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

	@JSON
	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_columnBitmask |= ESFUSERID_COLUMN_BITMASK;

		if (!_setOriginalEsfUserId) {
			_setOriginalEsfUserId = true;

			_originalEsfUserId = _esfUserId;
		}

		_esfUserId = esfUserId;
	}

	@Override
	public String getEsfUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfUserId(), "uuid", _esfUserUuid);
	}

	@Override
	public void setEsfUserUuid(String esfUserUuid) {
		_esfUserUuid = esfUserUuid;
	}

	public long getOriginalEsfUserId() {
		return _originalEsfUserId;
	}

	@JSON
	@Override
	public long getEsfFederalRoleId() {
		return _esfFederalRoleId;
	}

	@Override
	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_columnBitmask |= ESFFEDERALROLEID_COLUMN_BITMASK;

		if (!_setOriginalEsfFederalRoleId) {
			_setOriginalEsfFederalRoleId = true;

			_originalEsfFederalRoleId = _esfFederalRoleId;
		}

		_esfFederalRoleId = esfFederalRoleId;
	}

	public long getOriginalEsfFederalRoleId() {
		return _originalEsfFederalRoleId;
	}

	@JSON
	@Override
	public long getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(long startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
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
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	@JSON
	@Override
	public long getEsfSpecificId() {
		return _esfSpecificId;
	}

	@Override
	public void setEsfSpecificId(long esfSpecificId) {
		_esfSpecificId = esfSpecificId;
	}

	@JSON
	@Override
	public String getRegionId() {
		if (_regionId == null) {
			return StringPool.BLANK;
		}
		else {
			return _regionId;
		}
	}

	@Override
	public void setRegionId(String regionId) {
		_regionId = regionId;
	}

	@JSON
	@Override
	public String getProvinceId() {
		if (_provinceId == null) {
			return StringPool.BLANK;
		}
		else {
			return _provinceId;
		}
	}

	@Override
	public void setProvinceId(String provinceId) {
		_provinceId = provinceId;
	}

	@JSON
	@Override
	public String getNotes() {
		if (_notes == null) {
			return StringPool.BLANK;
		}
		else {
			return _notes;
		}
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ESFUserESFFederalRole toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFUserESFFederalRole)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFUserESFFederalRoleImpl esfUserESFFederalRoleImpl = new ESFUserESFFederalRoleImpl();

		esfUserESFFederalRoleImpl.setEsfUserId(getEsfUserId());
		esfUserESFFederalRoleImpl.setEsfFederalRoleId(getEsfFederalRoleId());
		esfUserESFFederalRoleImpl.setStartDate(getStartDate());
		esfUserESFFederalRoleImpl.setEndDate(getEndDate());
		esfUserESFFederalRoleImpl.setModifiedDate(getModifiedDate());
		esfUserESFFederalRoleImpl.setActive(getActive());
		esfUserESFFederalRoleImpl.setEsfSpecificId(getEsfSpecificId());
		esfUserESFFederalRoleImpl.setRegionId(getRegionId());
		esfUserESFFederalRoleImpl.setProvinceId(getProvinceId());
		esfUserESFFederalRoleImpl.setNotes(getNotes());

		esfUserESFFederalRoleImpl.resetOriginalValues();

		return esfUserESFFederalRoleImpl;
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

		if (!(obj instanceof ESFUserESFFederalRole)) {
			return false;
		}

		ESFUserESFFederalRole esfUserESFFederalRole = (ESFUserESFFederalRole)obj;

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
	public void resetOriginalValues() {
		ESFUserESFFederalRoleModelImpl esfUserESFFederalRoleModelImpl = this;

		esfUserESFFederalRoleModelImpl._originalEsfUserId = esfUserESFFederalRoleModelImpl._esfUserId;

		esfUserESFFederalRoleModelImpl._setOriginalEsfUserId = false;

		esfUserESFFederalRoleModelImpl._originalEsfFederalRoleId = esfUserESFFederalRoleModelImpl._esfFederalRoleId;

		esfUserESFFederalRoleModelImpl._setOriginalEsfFederalRoleId = false;

		esfUserESFFederalRoleModelImpl._originalActive = esfUserESFFederalRoleModelImpl._active;

		esfUserESFFederalRoleModelImpl._setOriginalActive = false;

		esfUserESFFederalRoleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFUserESFFederalRole> toCacheModel() {
		ESFUserESFFederalRoleCacheModel esfUserESFFederalRoleCacheModel = new ESFUserESFFederalRoleCacheModel();

		esfUserESFFederalRoleCacheModel.esfUserId = getEsfUserId();

		esfUserESFFederalRoleCacheModel.esfFederalRoleId = getEsfFederalRoleId();

		esfUserESFFederalRoleCacheModel.startDate = getStartDate();

		Date endDate = getEndDate();

		if (endDate != null) {
			esfUserESFFederalRoleCacheModel.endDate = endDate.getTime();
		}
		else {
			esfUserESFFederalRoleCacheModel.endDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfUserESFFederalRoleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfUserESFFederalRoleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfUserESFFederalRoleCacheModel.active = getActive();

		esfUserESFFederalRoleCacheModel.esfSpecificId = getEsfSpecificId();

		esfUserESFFederalRoleCacheModel.regionId = getRegionId();

		String regionId = esfUserESFFederalRoleCacheModel.regionId;

		if ((regionId != null) && (regionId.length() == 0)) {
			esfUserESFFederalRoleCacheModel.regionId = null;
		}

		esfUserESFFederalRoleCacheModel.provinceId = getProvinceId();

		String provinceId = esfUserESFFederalRoleCacheModel.provinceId;

		if ((provinceId != null) && (provinceId.length() == 0)) {
			esfUserESFFederalRoleCacheModel.provinceId = null;
		}

		esfUserESFFederalRoleCacheModel.notes = getNotes();

		String notes = esfUserESFFederalRoleCacheModel.notes;

		if ((notes != null) && (notes.length() == 0)) {
			esfUserESFFederalRoleCacheModel.notes = null;
		}

		return esfUserESFFederalRoleCacheModel;
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

	private static ClassLoader _classLoader = ESFUserESFFederalRole.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFUserESFFederalRole.class
		};
	private long _esfUserId;
	private String _esfUserUuid;
	private long _originalEsfUserId;
	private boolean _setOriginalEsfUserId;
	private long _esfFederalRoleId;
	private long _originalEsfFederalRoleId;
	private boolean _setOriginalEsfFederalRoleId;
	private long _startDate;
	private Date _endDate;
	private Date _modifiedDate;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private long _esfSpecificId;
	private String _regionId;
	private String _provinceId;
	private String _notes;
	private long _columnBitmask;
	private ESFUserESFFederalRole _escapedModel;
}