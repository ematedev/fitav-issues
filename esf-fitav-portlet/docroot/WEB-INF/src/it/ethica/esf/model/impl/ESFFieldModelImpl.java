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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFFieldModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFField service. Represents a row in the &quot;ESFField&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFFieldModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFFieldImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFFieldImpl
 * @see it.ethica.esf.model.ESFField
 * @see it.ethica.esf.model.ESFFieldModel
 * @generated
 */
@JSON(strict = true)
public class ESFFieldModelImpl extends BaseModelImpl<ESFField>
	implements ESFFieldModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f field model instance should use the {@link it.ethica.esf.model.ESFField} interface instead.
	 */
	public static final String TABLE_NAME = "ESFField";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "esfFieldId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "ownerOrganizationId", Types.BIGINT },
			{ "esfAddressId", Types.BIGINT },
			{ "billboard", Types.BIGINT },
			{ "billboardStations", Types.BOOLEAN },
			{ "backgroundRampart", Types.BOOLEAN },
			{ "backgroundNet", Types.BOOLEAN },
			{ "backgroundLeadRecovery", Types.BOOLEAN },
			{ "disabledAccess", Types.BOOLEAN },
			{ "note", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFField (uuid_ VARCHAR(75) null,esfFieldId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,ownerOrganizationId LONG,esfAddressId LONG,billboard LONG,billboardStations BOOLEAN,backgroundRampart BOOLEAN,backgroundNet BOOLEAN,backgroundLeadRecovery BOOLEAN,disabledAccess BOOLEAN,note VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFField";
	public static final String ORDER_BY_JPQL = " ORDER BY esfField.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFField.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFField"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFField"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFField"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long NAME_COLUMN_BITMASK = 4L;
	public static long OWNERORGANIZATIONID_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFField"));

	public ESFFieldModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfFieldId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfFieldId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfFieldId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFField.class;
	}

	@Override
	public String getModelClassName() {
		return ESFField.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfFieldId", getEsfFieldId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("ownerOrganizationId", getOwnerOrganizationId());
		attributes.put("esfAddressId", getEsfAddressId());
		attributes.put("billboard", getBillboard());
		attributes.put("billboardStations", getBillboardStations());
		attributes.put("backgroundRampart", getBackgroundRampart());
		attributes.put("backgroundNet", getBackgroundNet());
		attributes.put("backgroundLeadRecovery", getBackgroundLeadRecovery());
		attributes.put("disabledAccess", getDisabledAccess());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfFieldId = (Long)attributes.get("esfFieldId");

		if (esfFieldId != null) {
			setEsfFieldId(esfFieldId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long ownerOrganizationId = (Long)attributes.get("ownerOrganizationId");

		if (ownerOrganizationId != null) {
			setOwnerOrganizationId(ownerOrganizationId);
		}

		Long esfAddressId = (Long)attributes.get("esfAddressId");

		if (esfAddressId != null) {
			setEsfAddressId(esfAddressId);
		}

		Long billboard = (Long)attributes.get("billboard");

		if (billboard != null) {
			setBillboard(billboard);
		}

		Boolean billboardStations = (Boolean)attributes.get("billboardStations");

		if (billboardStations != null) {
			setBillboardStations(billboardStations);
		}

		Boolean backgroundRampart = (Boolean)attributes.get("backgroundRampart");

		if (backgroundRampart != null) {
			setBackgroundRampart(backgroundRampart);
		}

		Boolean backgroundNet = (Boolean)attributes.get("backgroundNet");

		if (backgroundNet != null) {
			setBackgroundNet(backgroundNet);
		}

		Boolean backgroundLeadRecovery = (Boolean)attributes.get(
				"backgroundLeadRecovery");

		if (backgroundLeadRecovery != null) {
			setBackgroundLeadRecovery(backgroundLeadRecovery);
		}

		Boolean disabledAccess = (Boolean)attributes.get("disabledAccess");

		if (disabledAccess != null) {
			setDisabledAccess(disabledAccess);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
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
	public long getEsfFieldId() {
		return _esfFieldId;
	}

	@Override
	public void setEsfFieldId(long esfFieldId) {
		_esfFieldId = esfFieldId;
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
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
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
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public long getOwnerOrganizationId() {
		return _ownerOrganizationId;
	}

	@Override
	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_columnBitmask |= OWNERORGANIZATIONID_COLUMN_BITMASK;

		if (!_setOriginalOwnerOrganizationId) {
			_setOriginalOwnerOrganizationId = true;

			_originalOwnerOrganizationId = _ownerOrganizationId;
		}

		_ownerOrganizationId = ownerOrganizationId;
	}

	public long getOriginalOwnerOrganizationId() {
		return _originalOwnerOrganizationId;
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
	public long getBillboard() {
		return _billboard;
	}

	@Override
	public void setBillboard(long billboard) {
		_billboard = billboard;
	}

	@JSON
	@Override
	public boolean getBillboardStations() {
		return _billboardStations;
	}

	@Override
	public boolean isBillboardStations() {
		return _billboardStations;
	}

	@Override
	public void setBillboardStations(boolean billboardStations) {
		_billboardStations = billboardStations;
	}

	@JSON
	@Override
	public boolean getBackgroundRampart() {
		return _backgroundRampart;
	}

	@Override
	public boolean isBackgroundRampart() {
		return _backgroundRampart;
	}

	@Override
	public void setBackgroundRampart(boolean backgroundRampart) {
		_backgroundRampart = backgroundRampart;
	}

	@JSON
	@Override
	public boolean getBackgroundNet() {
		return _backgroundNet;
	}

	@Override
	public boolean isBackgroundNet() {
		return _backgroundNet;
	}

	@Override
	public void setBackgroundNet(boolean backgroundNet) {
		_backgroundNet = backgroundNet;
	}

	@JSON
	@Override
	public boolean getBackgroundLeadRecovery() {
		return _backgroundLeadRecovery;
	}

	@Override
	public boolean isBackgroundLeadRecovery() {
		return _backgroundLeadRecovery;
	}

	@Override
	public void setBackgroundLeadRecovery(boolean backgroundLeadRecovery) {
		_backgroundLeadRecovery = backgroundLeadRecovery;
	}

	@JSON
	@Override
	public boolean getDisabledAccess() {
		return _disabledAccess;
	}

	@Override
	public boolean isDisabledAccess() {
		return _disabledAccess;
	}

	@Override
	public void setDisabledAccess(boolean disabledAccess) {
		_disabledAccess = disabledAccess;
	}

	@JSON
	@Override
	public String getNote() {
		if (_note == null) {
			return StringPool.BLANK;
		}
		else {
			return _note;
		}
	}

	@Override
	public void setNote(String note) {
		_note = note;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFField.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFField.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFField toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFField)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFFieldImpl esfFieldImpl = new ESFFieldImpl();

		esfFieldImpl.setUuid(getUuid());
		esfFieldImpl.setEsfFieldId(getEsfFieldId());
		esfFieldImpl.setGroupId(getGroupId());
		esfFieldImpl.setCompanyId(getCompanyId());
		esfFieldImpl.setUserId(getUserId());
		esfFieldImpl.setUserName(getUserName());
		esfFieldImpl.setCreateDate(getCreateDate());
		esfFieldImpl.setModifiedDate(getModifiedDate());
		esfFieldImpl.setName(getName());
		esfFieldImpl.setOwnerOrganizationId(getOwnerOrganizationId());
		esfFieldImpl.setEsfAddressId(getEsfAddressId());
		esfFieldImpl.setBillboard(getBillboard());
		esfFieldImpl.setBillboardStations(getBillboardStations());
		esfFieldImpl.setBackgroundRampart(getBackgroundRampart());
		esfFieldImpl.setBackgroundNet(getBackgroundNet());
		esfFieldImpl.setBackgroundLeadRecovery(getBackgroundLeadRecovery());
		esfFieldImpl.setDisabledAccess(getDisabledAccess());
		esfFieldImpl.setNote(getNote());

		esfFieldImpl.resetOriginalValues();

		return esfFieldImpl;
	}

	@Override
	public int compareTo(ESFField esfField) {
		int value = 0;

		value = getName().compareTo(esfField.getName());

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

		if (!(obj instanceof ESFField)) {
			return false;
		}

		ESFField esfField = (ESFField)obj;

		long primaryKey = esfField.getPrimaryKey();

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
		ESFFieldModelImpl esfFieldModelImpl = this;

		esfFieldModelImpl._originalUuid = esfFieldModelImpl._uuid;

		esfFieldModelImpl._originalGroupId = esfFieldModelImpl._groupId;

		esfFieldModelImpl._setOriginalGroupId = false;

		esfFieldModelImpl._originalCompanyId = esfFieldModelImpl._companyId;

		esfFieldModelImpl._setOriginalCompanyId = false;

		esfFieldModelImpl._originalName = esfFieldModelImpl._name;

		esfFieldModelImpl._originalOwnerOrganizationId = esfFieldModelImpl._ownerOrganizationId;

		esfFieldModelImpl._setOriginalOwnerOrganizationId = false;

		esfFieldModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFField> toCacheModel() {
		ESFFieldCacheModel esfFieldCacheModel = new ESFFieldCacheModel();

		esfFieldCacheModel.uuid = getUuid();

		String uuid = esfFieldCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			esfFieldCacheModel.uuid = null;
		}

		esfFieldCacheModel.esfFieldId = getEsfFieldId();

		esfFieldCacheModel.groupId = getGroupId();

		esfFieldCacheModel.companyId = getCompanyId();

		esfFieldCacheModel.userId = getUserId();

		esfFieldCacheModel.userName = getUserName();

		String userName = esfFieldCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfFieldCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfFieldCacheModel.createDate = createDate.getTime();
		}
		else {
			esfFieldCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfFieldCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfFieldCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfFieldCacheModel.name = getName();

		String name = esfFieldCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfFieldCacheModel.name = null;
		}

		esfFieldCacheModel.ownerOrganizationId = getOwnerOrganizationId();

		esfFieldCacheModel.esfAddressId = getEsfAddressId();

		esfFieldCacheModel.billboard = getBillboard();

		esfFieldCacheModel.billboardStations = getBillboardStations();

		esfFieldCacheModel.backgroundRampart = getBackgroundRampart();

		esfFieldCacheModel.backgroundNet = getBackgroundNet();

		esfFieldCacheModel.backgroundLeadRecovery = getBackgroundLeadRecovery();

		esfFieldCacheModel.disabledAccess = getDisabledAccess();

		esfFieldCacheModel.note = getNote();

		String note = esfFieldCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			esfFieldCacheModel.note = null;
		}

		return esfFieldCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfFieldId=");
		sb.append(getEsfFieldId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", ownerOrganizationId=");
		sb.append(getOwnerOrganizationId());
		sb.append(", esfAddressId=");
		sb.append(getEsfAddressId());
		sb.append(", billboard=");
		sb.append(getBillboard());
		sb.append(", billboardStations=");
		sb.append(getBillboardStations());
		sb.append(", backgroundRampart=");
		sb.append(getBackgroundRampart());
		sb.append(", backgroundNet=");
		sb.append(getBackgroundNet());
		sb.append(", backgroundLeadRecovery=");
		sb.append(getBackgroundLeadRecovery());
		sb.append(", disabledAccess=");
		sb.append(getDisabledAccess());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFField");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfFieldId</column-name><column-value><![CDATA[");
		sb.append(getEsfFieldId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getOwnerOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfAddressId</column-name><column-value><![CDATA[");
		sb.append(getEsfAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billboard</column-name><column-value><![CDATA[");
		sb.append(getBillboard());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billboardStations</column-name><column-value><![CDATA[");
		sb.append(getBillboardStations());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backgroundRampart</column-name><column-value><![CDATA[");
		sb.append(getBackgroundRampart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backgroundNet</column-name><column-value><![CDATA[");
		sb.append(getBackgroundNet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backgroundLeadRecovery</column-name><column-value><![CDATA[");
		sb.append(getBackgroundLeadRecovery());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disabledAccess</column-name><column-value><![CDATA[");
		sb.append(getDisabledAccess());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFField.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFField.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _esfFieldId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _originalName;
	private long _ownerOrganizationId;
	private long _originalOwnerOrganizationId;
	private boolean _setOriginalOwnerOrganizationId;
	private long _esfAddressId;
	private long _billboard;
	private boolean _billboardStations;
	private boolean _backgroundRampart;
	private boolean _backgroundNet;
	private boolean _backgroundLeadRecovery;
	private boolean _disabledAccess;
	private String _note;
	private long _columnBitmask;
	private ESFField _escapedModel;
}